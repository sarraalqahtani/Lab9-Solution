import java.util.Comparator;

public class Iris {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String species;

    //default constructor
    public Iris(){
        sepalLength = 0.0;
        sepalWidth = 0.0;
        petalLength = 0.0;
        petalWidth = 0.0;
        species = "unknown";
    }

    //parameterized constructor
    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    //copy constructor
    public Iris(Iris iris){
        sepalLength = iris.sepalLength;
        sepalWidth = iris.sepalWidth;
        petalLength = iris.petalLength;
        petalWidth = iris.petalWidth;
        species = iris.species;
    }

    //getter of sepalLenbth
    public double getSepalLength(){
        return sepalLength;
    }

    //getter of petalLength
    public double getPetalLength(){
        return petalLength;
    }

    @Override
    //override toString method
    public String toString(){
        return sepalLength+","+sepalWidth+","+petalLength+","+petalWidth+","+species;
    }

    //according to Professor Alqahtani, compareTo method does not need to be constructed because
    //compareTo is not a pre-constructed method in Comparator interface, so
    //in method isLessThan, we will use compare method from irisComparator class instead of compareTo

    //comparing method
    public boolean isLessThan(Iris Iris2){
        irisComparator comparatorVal = new irisComparator();//initialize irisComparator object for comparison
        int val = comparatorVal.compare(this, Iris2);//compare the two target objects
        if (val < 0){
            return true;
        }
        else{
            return false;
        }
    }

}

class irisComparator implements Comparator<Iris> {
    public int compare(Iris iris1, Iris iris2){
        //compare sepalLength and petalLength
        int sepalCompare = Double.compare(iris1.getSepalLength(), iris2.getSepalLength());
        int petalCompare = Double.compare(iris1.getPetalLength(), iris2.getPetalLength());
        if(sepalCompare == 0){
            //if sepals are the same and petals are the same as well, then iris1 > iris2
            if (petalCompare == 0){
                return 1;
            }
            //if sepals are the same and iris1 has longer petal, then iris1>iris2
            //if sepals are the same and iris1 has shorter petal, then iris1<iris2
            else{
                return petalCompare;
            }
        }
        //if iris1 has longer sepal, then iris1 > iris2; if iris1 has shorter sepal, then iris1 < iris2
        else{
            return sepalCompare;
        }
    }
}