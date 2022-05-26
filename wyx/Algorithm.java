package wyx;

public class Algorithm {
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orginColor = image[sr][sc];
        if(newColor != orginColor) {
            dfs(image,sr,sc,orginColor,newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int orginColor,int newColor){
        if(x<0|| x>=image.length || y<0||y>=image[0].length) {
            return;
        }
        if(image[x][y] == orginColor){
            image[x][y] = newColor;
            dfs(image,x+1,y,orginColor,newColor);
            dfs(image,x-1,y,orginColor,newColor);
            dfs(image,x,y+1,orginColor,newColor);
            dfs(image,x,y-1,orginColor,newColor);
        }
    }
}
