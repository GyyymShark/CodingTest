import java.util.*;
import java.io.*;

class Main{

    static class Sticker{
        int r;
        int c;
        int[][] map;
        Sticker(int r, int c){
            this.r=r;
            this.c=c;
            map=new int[r][c];
        }
    }
    static int n,m, size;
    static int[][] notebook;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static ArrayList<Sticker> stickerList=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        size=Integer.parseInt(st.nextToken());

        notebook=new int[n][m];

        for(int i=0; i<size; i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            stickerList.add(new Sticker(r,c));
            for(int j=0; j<r; j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0; k<c; k++){
                    stickerList.get(i).map[j][k]=Integer.parseInt(st.nextToken());
                }
            }
        }

        func();
        printOne();

    }


    static void printOne(){
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(notebook[i][j]==1)
                    count++;
            }
        }
        System.out.println(count);
    }

    static void func(){
        for(int i=0; i<size; i++){
            for(int j=0; j<4; j++){
                Point point;
                point=findLocation(i);

                if(point.x==-9999 && point.y==-9999){  //위치를 못 찾았을때
                    rotation(i);//90도 회전
                }
                else{   //위치를 찾았을때
                    putOn(point.x, point.y, i);    //스티커를 붙인다
                    break;
                }
            }
        }
    }

    static void rotation(int idx){
        Sticker sticker=stickerList.get(idx);
        int[][] copymap=copy(idx);

        int tmp=sticker.r;
        sticker.r=sticker.c;        //행 열 변환
        sticker.c=tmp;

        sticker.map=new int[sticker.r][sticker.c];  //새로 할당

        for(int i=0; i<sticker.r; i++){
            int xidx=sticker.c-1;
            for(int j=0; j<sticker.c; j++){
                sticker.map[i][j]=copymap[xidx][i];
                xidx--;
            }
        }
    }

    static int[][] copy(int idx){
        Sticker sticker=stickerList.get(idx);
        int[][] copymap=new int[sticker.r][sticker.c];

        for(int i=0; i<sticker.r; i++){
            for(int j=0; j<sticker.c; j++){
                copymap[i][j]=sticker.map[i][j];
            }
        }
        return copymap;
    }


    static void putOn(int startX, int startY, int idx){
        Sticker sticker=stickerList.get(idx);

        for(int i=startX; i<startX+sticker.r; i++){
            for(int j=startY; j<startY+sticker.c; j++){
                if(notebook[i][j]==0 && sticker.map[i-startX][j-startY]==1)
                notebook[i][j]=sticker.map[i-startX][j-startY];
            }
        }

    }

    static Point findLocation(int idx){
        Sticker sticker=stickerList.get(idx);
        int r=sticker.r;
        int c=sticker.c;

        for(int i=0; i<=n-r; i++){  //행
            for(int j=0; j<=m-c; j++){  //열
                boolean possible=compare(i,j,idx);
                if(possible){
                    return new Point(i,j);
                }
            }
        }

        return new Point(-9999,-9999);


    }


    static boolean compare(int x, int y, int idx){  //x행 y열
        Sticker sticker=stickerList.get(idx);
        boolean possible=true;

        for(int i=x; i<x+sticker.r; i++){  //행
            for(int j=y; j<y+sticker.c; j++){  //열
                if(notebook[i][j]==1 && sticker.map[i-x][j-y]==1){
                    possible=false;
                    return false;
                }
            }
        }
        return true;

    }

    static void printEach(int idx){
        Sticker sticker=stickerList.get(idx);

        for(int i=0; i<sticker.r; i++){
            for(int j=0; j<sticker.c; j++){
                System.out.print(sticker.map[i][j]+" ");
            }
            System.out.println();
        }
    }




    static void printNotebook(){
        System.out.println("notebeook");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(notebook[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }



}