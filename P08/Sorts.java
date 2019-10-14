import java.lang.reflect.Array;
import java.util.Arrays;

/**
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] a)
    {
        int pass,temp;
        boolean sorted;

        pass = 0;
        do
        {
            sorted = true;
            for (int  ii = 0; ii < (a.length-1 - pass); ii++)
            {
                if(a[ii] > a[ii+1])
                {
                    temp = a[ii];
                    a[ii] = a[ii+1];
                    a[ii+1] = temp;
                    sorted = false;
                }
            }
                pass += 1;
        }
        while (sorted == false);
    }//bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int temp, ArrayLengthDec1, minIndex;
        
        ArrayLengthDec1 = A.length-1;
        
        for(int nn = 0; nn <= ArrayLengthDec1; nn++)
        {
            minIndex = nn;
            for(int jj = nn+1; jj <= ArrayLengthDec1; jj++)
            {
                if(A[jj] < A[minIndex])
                {
                    minIndex = jj;
                }
            }
            temp = A[minIndex];
            A[minIndex] = A[nn];
            A[nn] = temp;
        } 
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int nn, temp;
        int arrayDec1;
        
        arrayDec1 =  A.length -1;
        
        for(nn = 1; nn < arrayDec1; nn++)
        {
            int ii = nn;
            while(ii > 0 && (A[ii-1] > A[ii]))
            {
                temp = A[ii];
                A[ii] = A[ii-1];
                A[ii-1] = temp;
                
                ii -= 1;
            }

        }

    }

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
        int rightIndex = A.length - 1;
        int leftIndex = 0;
        
        mergeSortRecurse(A,leftIndex,rightIndex);
        
    }
    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        if(leftIdx < rightIdx)
        {
            int midIdx = (leftIdx + rightIdx)/2;
            mergeSortRecurse(A,leftIdx,midIdx);
            mergeSortRecurse(A,midIdx+1,rightIdx);
            merge(A,leftIdx,midIdx,rightIdx);
        }
    }
    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int [] tempArr = new int[rightIdx - leftIdx +1];
        int ii,jj,kk;

        ii = leftIdx;
        jj = midIdx + 1;
        kk = 0;
    
        while(ii<=midIdx && jj <= rightIdx)
        {
            if(A[ii] <= A[jj])
            {
                tempArr[kk] = A[ii];
                ii++;
            }
            else
            {
                tempArr[kk] = A[jj];
                jj = jj+1;
            }
            kk++;
        }

        for(ii=ii; ii<=midIdx; ii++)
        {
            tempArr[kk] = A[ii];
            kk+=1;
        }
        
        for(jj=jj; jj<=rightIdx; jj++)
        {
            tempArr[kk] = A[jj];
            kk+=1;
        }
    
        for(kk=leftIdx; kk<=rightIdx; kk++)
        {
            A[kk] = tempArr[kk-leftIdx];
        }
    }


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {

        int rightIndex = A.length - 1;
        int leftIndex = 0;

        quickSortRecurse(A,leftIndex,rightIndex);
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIndex, newPivotIndex;
        if (rightIdx>leftIdx)
        {
            pivotIndex = (leftIdx+rightIdx)/2;
            newPivotIndex = doPartitioning(A,leftIdx,rightIdx,pivotIndex);
            quickSortRecurse(A,leftIdx,newPivotIndex-1);
            quickSortRecurse(A,newPivotIndex+1,rightIdx);
        }
    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        int pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;

        int currIdx;
        currIdx= leftIdx;
        int temp;
        for (int ii = leftIdx; ii<=rightIdx - 1; ii++)
        {
            if (A[ii]<=pivotVal)
            {
                temp = A[ii];
                A[ii]=A[currIdx];
                A[currIdx]=temp;
                currIdx = currIdx +1;
            }
        }
        int newPivIdx = currIdx;
        A[rightIdx] = A[newPivIdx];
        A[newPivIdx]=pivotVal;

		return newPivIdx;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning


    public static void randomQuicksort(int [] A)
    {
        int rightIndex = A.length - 1;
        int leftIndex = 0;

        randomQuicksortRecurse(A,leftIndex,rightIndex);
    }

    private static void randomQuicksortRecurse(int [] A, int leftIndex, int rightIndex)
    {
        if (leftIndex < rightIndex)
        {
            int partition = randomQuicksortPartitioning(A,leftIndex,rightIndex);
            quickSortRecurse(A,leftIndex,partition-1);
            quickSortRecurse(A,partition+1,rightIndex);
        }

    }

    private static int randomQuicksortPartitioning(int [] A, int leftindex, int rightIndex)
    {
        int pivot = A[leftindex];
        int split = leftindex;

        for (int i= leftindex; i<rightIndex; i++)
        {
            if (pivot > A[i])
            {
                swap(A,++split,i);
            }
        }

        swap(A,leftindex,split);

        return split;

    }

    private static void swap(int A[],int left, int right)
    {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }

    public static void threeWayQuickSort(int [] A)
    {

        int leftindex = 0;
        int rightindex = A.length-1;

        threeWayQuickSortRecursion(A,leftindex,rightindex);
    }

    public static void threeWayQuickSortRecursion(int [] A, int leftindex, int rightindex)
    {
        int i=0,j=0;
        if (leftindex <= rightindex)
        {
            threeWayPartition(A,leftindex,rightindex,i,j);
            quickSortRecurse(A,leftindex,j);
            quickSortRecurse(A,i,rightindex);
        }
    }

    public static void threeWayPartition(int [] A, int leftindex, int rightindex, int i, int j)
    {
        if (rightindex - leftindex <= 1)
        {
            if (A[rightindex] <A[leftindex])
            {
                swap(A,rightindex,leftindex);
            }
            i = leftindex;
            j = rightindex;
        }
        else
        {
            int mid = leftindex;
            int pivot = A[rightindex];
            while (mid <= rightindex)
            {
                if (A[mid] < pivot)
                {
                    swap(A,leftindex++, mid++);
                }
                else if (A[mid]==pivot)
                {
                    mid++;
                }
                else if (A[mid]>pivot)
                {
                    swap(A,mid,rightindex--);
                }
            }
            i = leftindex-1;
            j = mid;
        }
    }




}//end Sorts calss
