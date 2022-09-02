package PortaldanMonster;

public class Graph {
    int vertex;
    LinkedList[] list;
    int[] passed;

    Graph(int vertex){
        this.vertex = vertex;
        list = new LinkedList[vertex];
        passed = new int[vertex];
    }

    byte getMonster(int i){
        return list[i].monster;
    }

    void addEdge(int source, int destination){
        list[source].addFirst(destination);

        // for undirected graph
        // list[destination].addFirst(source);
    }

    void totalMonster(int i, byte monster){
        list[i] = new LinkedList(monster);
    }

    int minEnergy(){
        int energy=list[0].monster, times=1, a=0;
        passed[a] = 0;
        for (int i = 0; i < vertex; i++) {
            if(list[i].size > 0){
                int mns = 0;
                if(!isPassed(i)){
                    a++;
                    passed[a] = i;
                    times++;
                    mns += list[i].monster;
                }
                for (int j = 0; j < list[i].size; j++) {
                    mns += list[list[i].get(j)].monster;
                    a++;
                    passed[a] = list[i].get(j); //sarang ke-a udh pernah dilewati
                }
                energy += mns * times;
            }
        }
        

        return energy;
    }

    boolean isPassed(int a){
        for (int i = 0; i < vertex; i++) {
            if(passed[i] == a) return true;
        }
        return false;
    }

    void printGraph(){
        for (int i = 0; i < vertex; i++) {
            if (list[i].size > 0) {
                System.out.printf("Sarang ke-%d terhubung dengan: ", i+1);
                for (int j = 0; j < list[i].size; j++) {
                    System.out.println((list[i].get(j)+1)+" ");
                }
                System.out.println();
            }
        }
    }

    double average(int[] a){
        int tot=0;
        for (int i : a) {
            tot += i;
        }
        return tot/a.length;
    }
}
