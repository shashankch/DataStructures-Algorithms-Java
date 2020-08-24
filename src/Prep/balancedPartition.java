package Prep;

import java.util.Scanner;

// https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/balanced-partition-818edecd/description/
public class balancedPartition {


//    public static String helper(String str) {

      



//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            

            int house = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < house; i++) {


                int x = sc.nextInt();
                int y = sc.nextInt();
                int h = sc.nextInt();


                

            }



        }
        


       


    }

}



//             v.push_back({y-x,h});
//             minn=min(minn,y-x);
//             maxx=max(maxx,y-x);
//         }
// int l = minn, r = maxx;
// int ans = r + 1;
// bool f = 0;while(l<=r)
// {
//     int mid = (l + r) / 2;
//     int val = mid;
//     int suma = 0, sumb = 0, sume = 0;
//     for (int i = 0; i < v.size(); i++) {
//         if (v[i].first < val)
//             suma += v[i].second;
//         else if (v[i].first == val)
//             sume += v[i].second;
//         else
//             sumb += v[i].second;
//     }
//     if (suma == sumb) {
//         f = 1;
//         break;
//     }
//     suma += sume;
//     if (suma > sumb) {
//         r = val - 1;
//     } else if (suma < sumb) {
//         l = val + 1;
//     } else {
//         f = 1;
//         break;
//     }

// }if(f)cout<<"YES\n";else cout<<"NO\n";
// }return 0;}
