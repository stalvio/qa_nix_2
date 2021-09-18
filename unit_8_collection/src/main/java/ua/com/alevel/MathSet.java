package ua.com.alevel;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MathSet {

    private static final int INITIAL_CAPACITY = 10;

    private Number[] mathSet;
    private int size;

    public MathSet() {
        this(INITIAL_CAPACITY);
    }

    public MathSet(int capacity) throws IllegalArgumentException {
        if (capacity >= 0) {
            mathSet = new Number[capacity];
        } else {
            throw new IllegalArgumentException("Invalid capacity!");
        }
    }

    MathSet(Number[] numbers) {
        this(numbers.length);
        add(numbers);
    }

    MathSet(Number[]... numbers) {
        mathSet = new Number[numbers.length * numbers[0].length];
        for (Number[] num : numbers) {
            add(num);
        }
    }

    MathSet(MathSet numbers) {
        this(numbers.size);
        join(numbers);
    }

    MathSet(MathSet... numbers) {
        this(numbers.length * INITIAL_CAPACITY);
        for (MathSet num : numbers) {
            join(num);
        }
    }


    void add(Number n) {
        if (mathSet.length == size) expandMathSet();
        if (isDistinct(n)) {
            mathSet[size++] = n;
        }
    }

    void add(Number... n) {
        for (int i = 0; i < n.length; i++)
            add(n[i]);
    }

    void join(MathSet ms) {
        if (ms.hasEntries()) {
            Number[] newArray = ms.toArray();
            add(newArray);
        }
    }

    void join(MathSet... ms) {
        for (MathSet m : ms) {
            this.join(m);
        }
    }

    void intersection(MathSet ms) {
        if (ms.hasEntries() && this.hasEntries()) {
            MathSet newMathSet = new MathSet();

            for (int i = 0; i < ms.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (ms.get(i) == this.get(j)) {
                        newMathSet.add(ms.get(i));
                        break;
                    }
                }
            }
            mathSet = newMathSet.toArray();
            size = newMathSet.size;
        } else {
            System.out.println("No values to intersect");
        }
    }

    void intersection(MathSet... ms) {
        for (MathSet m : ms) {
            intersection(m);
        }
    }

    void sortDesc() {
        sortDesc(0, size - 1);
    }

    void sortDesc(int firstIndex, int lastIndex) {
        areIndexesValid(firstIndex, lastIndex);

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = i + 1; j <= lastIndex; j++) {
                    if ((mathSet[i].doubleValue() - mathSet[j].doubleValue()) < 0) {
                        Number tempNum = mathSet[i];
                        mathSet[i] = mathSet[j];
                        mathSet[j] = tempNum;
                        isSorted = false;
                    }
                }
            }
        }
    }

    void sortDesc(Number value) {
        sortDesc(getIndex(value), size - 1);
    }

    void sortAsc() {
        sortAsc(0, size - 1);
    }

    void sortAsc(int firstIndex, int lastIndex) {
        areIndexesValid(firstIndex, lastIndex);

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = i + 1; j <= lastIndex; j++) {
                    if ((mathSet[i].doubleValue() - mathSet[j].doubleValue()) > 0) {
                        Number tempNum = mathSet[i];
                        mathSet[i] = mathSet[j];
                        mathSet[j] = tempNum;
                        isSorted = false;
                    }
                }
            }
        }
    }

    void sortAsc(Number value) {
        sortAsc(getIndex(value), size - 1);
    }

    Number get(int index) {
        if (isIndexValid(index))
            return mathSet[index];
        return null;
    }

    Number getMax() {
        if (hasEntries()) {
            MathSet tempSet = new MathSet(getArrayCopy(mathSet));
            tempSet.sortDesc();

            return mathSet[getIndex(tempSet.get(0))];
        }
        throw new IllegalStateException("No elements are added yet");
    }

    Number getMin() {
        if (hasEntries()) {
            MathSet tempSet = new MathSet(getArrayCopy(mathSet));
            tempSet.sortAsc();

            return mathSet[getIndex(tempSet.get(0))];
        }
        throw new IllegalStateException("No elements are added yet");
    }

    Number getAverage() {
        if (hasEntries()) {
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum += mathSet[i].doubleValue();
            }
            return sum / size;
        } else {
            throw new IllegalStateException("No elements are added yet");
        }
    }

    Number getMedian() {
        Number median;
        Number[] tempArr = getArrayCopy(mathSet);
        sortAsc();
        median = mathSet[size / 2];
        mathSet = tempArr;
        return mathSet[getIndex(median)];
    }

    Number[] toArray() {
        Number[] newArray = new Number[this.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }

    Number[] toArray(int firstIndex, int lastIndex) {
        MathSet mathSet = cut(firstIndex, lastIndex);
        return mathSet.toArray();
    }

    MathSet cut(int firstIndex, int lastIndex) {
        MathSet newMathSet = null;

        if (areIndexesValid(firstIndex, lastIndex) && firstIndex < lastIndex) {
            newMathSet = new MathSet(lastIndex - firstIndex + 1);
            for (int i = firstIndex; i <= lastIndex; i++) {
                newMathSet.add(this.get(i));
            }
        } else {
            System.out.println("Indexes are invalid");
        }
        return newMathSet;
    }

    void clear() {
        mathSet = new Number[INITIAL_CAPACITY];
        size = 0;
    }

    void clear(Number[] numbers) {
        MathSet newSet = new MathSet(size);

        boolean isPresent;
        for (int i = 0; i < size; i++) {
            isPresent = false;

            for (int j = 0; j < numbers.length; j++) {
                if (mathSet[i].equals(numbers[j])) isPresent = true;
            }
            if (!isPresent) newSet.add(mathSet[i]);
        }
        mathSet = newSet.mathSet;
    }

    private void expandMathSet(int newSize) {
        Number[] newMathSet = new Number[newSize];
        for (int i = 0; i < mathSet.length; i++) {
            newMathSet[i] = mathSet[i];
        }
        mathSet = newMathSet;
    }

    private void expandMathSet() {
        expandMathSet(2 * size);
    }

    private boolean isDistinct(Number n) {
        if (n == null) return false;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (n.equals(mathSet[i]))
                    return false;
            }
        }
        return true;
    }

    private Number[] toArray(MathSet mathSet) {
        Number[] newArray = new Number[mathSet.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = mathSet.get(i);
        }
        return newArray;
    }

    private boolean isIndexValid(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size) return true;
        else {
            throw new IndexOutOfBoundsException("Index is out of the range: " + index);
        }
    }

    private boolean areIndexesValid(int... indexes) {
        for (int index : indexes) {
            if (!isIndexValid(index)) return false;
        }
        return true;
    }

    private boolean hasEntries() {
        return size > 0 ? true : false;
    }

    private int getIndex(Number n) throws NoSuchElementException {
        for (int i = 0; i < size; i++) {
            if (mathSet[i].equals(n)) return i;
        }
        throw new NoSuchElementException("No such an element found: " + n);
    }

    private Number[] getArrayCopy(Number[] originalArray) {
        Number[] copiedArray = new Number[size];
        for (int i = 0; i < size; i++) {
            if (!originalArray[i].equals(null))
                copiedArray[i] = originalArray[i];
        }
        return copiedArray;
    }

    // Method is made public only for the testing purposes
    @Override
    public String toString() {
        return "MathSet{" +
                "mathSet=" + Arrays.toString(mathSet) +
                ", size=" + size +
                ", current_capacity=" + mathSet.length +
                '}';
    }
}
