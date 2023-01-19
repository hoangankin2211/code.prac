class Union_Quick{
    private int[] id;
    
    public Union_Quick(int N){
        id = new int[N];
        for (int i=0;i<N;i++){
            id[i]=i;
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
        id[i]=j;       
    }
}

public class Union_Find{
    private int[] id;

    public Union_Find(int N){
        id = new int[N];
        for (int i=0;i<N;i++){
            id[i]=i;
        }
    }

    public boolean isConnected(int a,int b){
        return id[a]==id[b];
    }

    public void Union(int a,int b){
        int p=id[a], q=id[b];
        for (int i=0;i<id.length;i++){
            if (id[i]==p) id[i]=q;
        }
    }

    public static void main(String[] args) {
        Union_Quick UF = new Union_Quick(10);
        UF.Union(1,2);
        System.out.println(UF.isConnected(3,2));
    }
}

