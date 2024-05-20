package adapter;

import java.util.Enumeration;
import java.util.Vector;
import java.util.Iterator;

public class School {
    public static void main(String[] args) {
        Vector<Integer> group = new Vector<Integer>();
        group.add(90);
        group.add(100);
        group.add(78);

        Enumeration<Integer> group_enumerator = group.elements();
        School school = new School();
        Iterator<Integer> adapter = new EnumerationAdapter<Integer>(group_enumerator);
        double average = school.getAverage(adapter);
        System.out.println(average);
    }

    public double getAverage(Iterator<Integer> grade_it) {
        double sum = 0;
        int count = 0;
        while (grade_it.hasNext()) {
            double g = grade_it.next();
            sum += g;
            count++;
        }
        return sum / count;
    }
}

class EnumerationAdapter<E> implements Iterator<E> {
    private Enumeration<E> enumeration;

    public EnumerationAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}