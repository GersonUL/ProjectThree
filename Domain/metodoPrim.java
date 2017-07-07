package Domain;
import java.util.ArrayList;
import java.util.List;


public class metodoPrim{

  /*este metodo recibe una matriz bidimensional que representa un grafo, la matriz debe tener cumplir con:
  el numero de reglones debe ser el numero de aristas posibles si haber pares repetidos, debe tener 3 columnas
  en la primera columna debe especificar el peso de la arista correspondiente al par de nodos
  que seran especificados en la segunda y tercera columna 
  al terminar de aplicar el proceso el metodo regresa una matriz que representa el arbol recubridor
  minimal, el cual cumple con las anteriores especificaciones en cuanto a reglones y columnas*/
  public int[][] aplicaPrim(int[][] grafo, int nodos){
    int[][] grafoPrim;
    int tam_grafoPrim=0;
    List<Integer> conjunto = new ArrayList<Integer>();
    // esta lista representara el conjunto de nodos que ya pertenecen al arbol recubridor minimal
    conjunto.add(1); // siempre el nodo inicial sera el primero
    mergeSort(1,grafo.length,0,grafo); //se ordenaran los pesos de los nodos para ir seleccionando
    // y solo buscar aquellos que uno de sus vertices pertenezca al conjunto y el otro no
    do{
      for(int x=0;x<grafo.length;x++){
        if(grafo[x][0]>0){
          if( (conjunto.indexOf(grafo[x][1])>-1 && conjunto.indexOf(grafo[x][2])<0) ||
            (conjunto.indexOf(grafo[x][2])>-1 && conjunto.indexOf(grafo[x][1])<0) ){
              conjunto.add(conjunto.indexOf(grafo[x][1])>-1?grafo[x][2]:grafo[x][1]);
              // el nodo que aun no pertenece al conjunto se agrega al conjunto
              grafo[x][0]*=-1; // su valor se pone negativo para no considerarlo en futuras iteraciones
              tam_grafoPrim++; // al mismo tiempo se va calculando el tama�o del conjunto resultante
              mergeSort(1,grafo.length,0,grafo); // se vuelven a ordenar los pesos que aun estan fuera del conjunto
              x=grafo.length+1;
          }
        }
      }
    } while(conjunto.size()<nodos); // repetir ciclo mientras al conjunto le falten nodos
    grafoPrim = new int[tam_grafoPrim][3]; // se declara un nuevo arreglo para guardar las aristas obtenidas
    for(int x=0;x<tam_grafoPrim;x++){ // ahora solo hay que cargar los datos resultantes que ya estan ordenados
      grafoPrim[x][0] = grafo[x][0]*-1;
      grafoPrim[x][1] = grafo[x][1];
      grafoPrim[x][2] = grafo[x][2];
    }
    return grafoPrim;
  }

  /*Los 2 metodos siguientes son adaptacion del mergesort para que ordene una matriz
    bidimensional por reglones basandose en cualquier columna [...] */
   public void mergeSort(int l, int r, int col, int M[][]){
    int q;
    if(l<r){
      q=(int)(Math.floor((l+r)/2));
      mergeSort(l,q,col,M);
      mergeSort(q+1,r,col,M);
      merge(l,q,r,col,M);
    }
  }

  public void merge(int l, int q, int r, int col, int M[][]){
    int i;
    int j;
    int k = 0;
    int n = r-l+1;
    int[][] B = new int[n][3];
    for(i=l;i<=q;i++){
      B[k][0] = M[i-1][0];
      B[k][1] = M[i-1][1];
      B[k++][2] = M[i-1][2];
    }
    for(j=r;j>=q+1;j--){
      B[k][0]=M[j-1][0];
      B[k][1]=M[j-1][1];
      B[k++][2]=M[j-1][2];
    }
    i = 1; j = n; k = l;
    while (i<=j)
      if (B[i-1][col]<=B[j-1][col]){
        M[(k)-1][0] = B[(i)-1][0];
        M[(k)-1][1] = B[(i)-1][1];
        M[(k++)-1][2] = B[(i++)-1][2];
      }
      else{
        M[(k)-1][0] = B[(j)-1][0];
        M[(k)-1][1] = B[(j)-1][1];
        M[(k++)-1][2] = B[(j--)-1][2];
      }
  }
}