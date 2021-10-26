package Week7;

public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
    List<Integer> count = new ArrayList<>();
    for(int i=0;i<100;i++){
        count.add(0);
    }
    for(int i=0;i<arr.size();i++){
        int index = arr.get(i);
        count.set(index,count.get(arr.get(i))+1);
    }
    return count;
    }