import java.util.*;
import java.io.*;

class Main{
    static class Command{
        int second;
        char dir;

        Command(int second, char dir){
            this.second=second;
            this.dir=dir;
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,k,l,d=1;
    static int[][] map;
    static List<Command> command;
    static Deque<Point> snake=new LinkedList<>();

    static int[] dx={-1,0,1,0};    //상 우 하 좌
    static int[] dy={0,1,0,-1};

    public static void main(String[] args)throws IOException{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());
        map=new int[n+1][n+1];

        k=Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            map[r][c]=-1;
        }

        l=Integer.parseInt(br.readLine());

        command=new ArrayList<>();

        for(int i=0; i<l; i++){
            st=new StringTokenizer(br.readLine());
            int second=Integer.parseInt(st.nextToken());
            String dir=st.nextToken();
            command.add(new Command(second, dir.charAt(0)));
        }

        simulation();
    }

    static void simulation(){
        //상  우   좌  하
        //0   1   2   3

        snake.add(new Point(1,1));
        int time=0;
        int commandIdx=0;

        while(!snake.isEmpty()){
            Point head=snake.peekFirst();
            if(commandIdx<l) {
                if (time == command.get(commandIdx).second) { //방향전환
                    if (command.get(commandIdx).dir == 'D') { //시계방향 90도 회전
                        d = (d + 1) % 4;
                    } else if (command.get(commandIdx).dir == 'L') {    //반시계방향 90도 회전
                        d -= 1;
                        if (d == -1) d = 3;
                    }
                    commandIdx++;
                }
            }

            int x=head.x+dx[d];
            int y=head.y+dy[d];



            if(x<1 || x>n || y<1 || y>n){   //벽에 닿았을때(종료조건)
                break;
            }
            if(map[x][y]==1)    {   //자기자신과 만났을때(종료조건)
                break;
            }


            if(map[x][y]==-1){   //머리에 사과가 있을떄
                snake.addFirst(new Point(x,y));
                map[x][y]=1;
            }
            else {  //0일때
                snake.addFirst(new Point(x,y)); //머리 이동
                map[x][y]=1;    //머리 표시

                Point tail=snake.removeLast(); //꼬리 제거
                map[tail.x][tail.y]=0;  //꼬리 사라짐 표시
            }


            time++;
        }

        System.out.println(++time);

    }
}