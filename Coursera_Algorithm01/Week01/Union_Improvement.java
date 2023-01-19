public class Union_Improvement {
    private int[] id;
    private int[] size;

    public Union_Improvement(int N){
        id = new int[N];
        size = new int[N];

        for (int i=0;i<N;i++){
            id[i]=i;
            size[i]=0;
        }
        
    }

    private int root(int i){
        while (i!=id[i]) i=id[i];
        return i;
    }

    boolean isConnected(int a,int b){
        return root(a)==root(b);
    }

    public void Union(int a, int b){
        int i = root(a);
        int j = root(b);
        if (i==j) return;
        if (size[i] > size[j]) {
            id[j]=i;
            size[i]+=size[j];
        }
        else {
            id[i]=j;       
            size[j]+=size[i];
        }   
    }
    public static void main(String[] args) {
        System.out.print(new Union_Improvement(10).isConnected(1, 2));
    }
}
