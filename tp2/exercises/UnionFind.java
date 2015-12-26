package tp2.exercises;



public class UnionFind {
	 private int[] _parent;
	  private int[] _rank;

 public UnionFind(int max) {
	 max++;
    _parent = new int[max];
    _rank = new int[max];
    for (int i = 0; i < max; i++) {
      _parent[i] = i;
    }
 }
 
  public int find(int i) {
	int father = i;
        while (father != _parent[father]){
            father = _parent[father];
        }
        while (i != father) {
            int newi = _parent[i];
            _parent[i] = father;
            i = newi;
        }
        return father;
  }


  public void union(int i, int j) {

    int root1 = find(i);
    int root2 = find(j);

    if (root2 == root1) return;

    if (_rank[root1] > _rank[root2]) {
      _parent[root2] = root1;
    } else if (_rank[root2] > _rank[root1]) {
      _parent[root1] = root2;
    } else {
      _parent[root2] = root1;
      _rank[root1]++;
    }
  }


 
  }
