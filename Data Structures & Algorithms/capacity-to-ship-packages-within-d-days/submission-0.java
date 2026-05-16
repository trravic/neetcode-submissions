public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;

        while (l <= r) {
            int cap = (l + r) / 2;
            if (canShip(weights, days, cap)) {
                res = Math.min(res, cap);
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }
        return res;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int ships = 1, currCap = cap;
        for (int w : weights) {
            if (currCap - w < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currCap = cap;
            }
            currCap -= w;
        }
        return true;
    }
}



/**
Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

given the return least weight of ship 

It is not allowed to load weight more than the maximum weight capacity of the ship.

mean max(weights)

min = 2 max = 10 

days is 4 

you definitely need a ship standalone to ship maximum capacity 

because [2,4,6,1,3,10]

in this example you need minship capacity to 10 to ship it 



*/