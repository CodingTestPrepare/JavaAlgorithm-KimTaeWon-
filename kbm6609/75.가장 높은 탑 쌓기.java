import java.io.*;
import java.util.ArrayList;

/**
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
 * 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
 * (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
 * (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
 * (조건3) 벽돌들의 높이는 같을 수도 있다.
 * (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
 * (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
 */
public class Main {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
        }
        solution2(str, n);
    }

    /**
     * Version1
     * 실제로 연결을 시켜서 값을 구한 방식
     * 블럭간에 위에 올라갈수있는 블럭을 up 리스트에 저장하고
     * 이렇게 연결된 값들을 사용해서 새로 들어갈 블럭의 위치를 찾는다.
     */

    static void solution1(String[] str, int n) {
        ArrayList<Block> blocks = new ArrayList<>();
        ArrayList<Block> roots = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String[] tmp = str[i].split(" ");
            blocks.add(new Block(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }
        blocks.sort(Block::compareTo);
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            insertBlocks(roots, block, 0);
        }
        System.out.println(max);
    }


    static void insertBlocks(ArrayList<Block> underBlock, Block block, int sum) {
        boolean check = false;
        if (underBlock.contains(block)) {
            max = Math.max(sum + block.h, max);
            return;
        }
        for (int i = 0; i < underBlock.size(); i++) {
            Block upBlock = underBlock.get(i);
            int i1 = upBlock.compareBlock(block);
            if (i1 == -1) {
                check = true;
                insertBlocks(upBlock.up, block, sum + upBlock.h);
            }
        }
        if (!check) {
            underBlock.add(block);
            max = Math.max(sum + block.h, max);
        }
    }

    /**
     * VerSion2 (best)
     * version1 에서는 직접 up 리스트를 사용해서 연결하였지만
     * 실제로 사용하는것은 블럭의 높이만 필요로 하기 떄문에 직접 연결시킬 필요가 없었다.
     * 이 버젼에선 dp 배열을 사용해서 해당 블럭이 올라갈수있는 최대 높이만 찾아서
     * 새롭게 넣을 블럭이 해당 블럭 위에 올라갈수있는지 비교후 이전에 구한 해당 블럭의 최대 높이를 사용한다.
     */
    static void solution2(String[] str, int n) {
        ArrayList<Block> blocks = new ArrayList<>();
        int[] blockH = new int[n];
        for (int i = 0; i < str.length; i++) {
            String[] tmp = str[i].split(" ");
            blocks.add(new Block(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }
        blocks.sort(Block::compareTo);
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            blockH[i] = block.h;
            for (int j = i - 1; j >= 0; j--) {
                Block block2 = blocks.get(j);
                if (block2.compareBlock(block) == -1) {
                    blockH[i] = Math.max(blockH[i], blockH[j] + block.h);
                }
            }
            max = Math.max(max,blockH[i]);
        }

        System.out.println(max);
    }

}

class Block implements Comparable<Block> {
    int w, h, m;
    ArrayList<Block> up = new ArrayList<>();

    public Block(int w, int h, int m) {
        this.w = w;
        this.h = h;
        this.m = m;
    }

    public int compareBlock(Block block) {
        if (this.m > block.m) {
            return -1;
        }
        return 0;
    }

    @Override
    public int compareTo(Block o) {
        return o.w - this.w;
    }
}


