public int findDeepestPit(int[] heights) {

        int n = heights.length;

        if (n < 3) {
            return -1;
        }

        int maxDepth = -1;

        int leftPeak = 0;

        while (leftPeak < n - 2) {

            // Find the left peak
            while (leftPeak < n - 1 &&
                    heights[leftPeak] <= heights[leftPeak + 1]) {
                leftPeak++;
            }

            int bottom = leftPeak;

            // Move down to the bottom
            while (bottom < n - 1 &&
                    heights[bottom] > heights[bottom + 1]) {
                bottom++;
            }

            if (bottom == leftPeak) {
                leftPeak++;
                continue;
            }

            int rightPeak = bottom;

            while (rightPeak < n - 1 &&
                    heights[rightPeak] < heights[rightPeak + 1]) {
                rightPeak++;
            }

            if (rightPeak == bottom) {
                leftPeak = bottom;
                continue;
            }

            int leftWallHeight = heights[leftPeak] - heights[bottom];
            int rightWallHeight = heights[rightPeak] - heights[bottom];

            int currentDepth = Math.min(leftWallHeight, rightWallHeight);

            maxDepth = Math.max(maxDepth, currentDepth);

            leftPeak = rightPeak;
        }

        return maxDepth;
    }
}