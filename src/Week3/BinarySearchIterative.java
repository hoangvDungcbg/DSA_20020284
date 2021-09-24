import edu.princeton.cs.algs4.StdOut;

public class BinarySearchIterative {
    int binarysearchite(int a[], int key) {
        int lo = 0, hi = a.length - 1;
        while(lo<=hi){
            int mid=(lo+(hi-1))/2;
            if(a[mid]==key){
                return mid;
            }
            if(a[mid]>key){
                hi=mid+1;
            }
            if(a[mid]<key){
                lo=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        BinarySearchIterative bi=new BinarySearchIterative();
        int a[]={1,2,3,4,5,6,7,8,9,100};
        int len=a.length;
        int key=99;
        int result= bi.binarysearchite(a,key);
        if(result==-1){
            StdOut.println("Not found");
        }
        else{
            StdOut.println("LOCATION:"+result);
        }

    }
}
