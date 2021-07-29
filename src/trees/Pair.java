package trees;

public class Pair {

        public int height;
        public int diameter;
        //for largest bst case only:
        int max;
        int min;
        boolean isbst;

        public Pair(){

        }
        public Pair(int height,int diameter){

            this.height=height;
            this.diameter=diameter;

        }
}
