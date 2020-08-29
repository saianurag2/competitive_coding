public class GraphPrinter{
    public void printGraph(int[] data){
        int len = data.length;
        int[] steps = new int[len];
        int width, min, max;
        width = min = max = data[0];
        int maxCount  = 0;
        int base, height;
        base = height = 0;
        steps[0] = data[0];
        for(int k = 1; k< len; k++){
            width+=data[k];
            if(k%2 == 0)
                steps[k] = steps[k-1] + data[k];
            else
                steps[k] = steps[k-1] - 1*data[k];
        }
        //finding bounds
        for(int step : steps){
            if(min > step)
                min = step;
            else if(max < step){
                max = step;
                maxCount = 0;
            }
            if(max == step)
                maxCount++;
        }
        //setting bounds
        if( steps[len-1] == max){
            width++;// increase size to accommodate special symbol
        }
        width+=maxCount; // for special symbol
        if(min < 0){
            height = max + (-1*min) + 3;
            base = (-1*min);
        }else
            height = max + 3;
        char[][] printPattern = new char[height][width];
        for(int l = height-1; l > -1; l-- ){
            for(int b= 0; b < width; b++)
                printPattern[l][b] = ' ';
        }
        int x = 0;//origin
        int y = base;//origin
        for(int c = 0; c < len; c++){
            if(c%2 == 0){
                for(;y  < steps[c] + base ; y++){
                    printPattern[y][x] = '/';
                    x++;
                }
                if(y == max + base){
                    x--;
                    printPattern[y][x] = '<';
                    printPattern[y][x+1] = ' ';
                    printPattern[y][x+2] = '>';
                    printPattern[y+1][x] = '/';
                    printPattern[y+1][x+1] = '|';
                    printPattern[y+1][x+2] = '\\';
                    printPattern[y+2][x+1] = 'o';
                    x+=2;
                }
                --y;
            }else{ 
                for(;y >= steps[c]+ base; y--){
                    printPattern[y][x] = '\\';
                    x++;
                }
                ++y;
            }
        }
        for(int l = height-1; l > -1; l-- ){
            for(int b= 0; b < width; b++)
                System.out.print(printPattern[l][b]);
            System.out.println();
        }
    }
    public static void main(String[] args){

        GraphPrinter gp = new GraphPrinter();
        // int[] data = {10,7,12,2,4,7,2,4,1,2,6,6,3,2,1,4,7,2,7,3,1,3,11,4,2,1,5,2,3,3,3,6,1,3,9,5,2,1,2,11,9,2,3,8,2,5,1,2,7,2,4,11,2,12} ;
        int[] data = {10,20,20,4};
        gp.printGraph(data);
    }
}
