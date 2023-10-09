int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* numIndexMap = (int*)malloc(sizeof(int) * 10001);
    for (int i = 0; i < 10001; ++i) {
        numIndexMap[i] = -1;
    }
    for (int i = 0; i < numsSize; ++i) {
        int complement = target - nums[i];
        if (numIndexMap[complement] != -1) {
            int* result = (int*)malloc(sizeof(int) * 2);
            result[0] = numIndexMap[complement];
            result[1] = i;
            *returnSize = 2;
            free(numIndexMap);
            return result;
        }
        numIndexMap[nums[i]] = i;
    }
    *returnSize = 0;
    free(numIndexMap);
    return NULL;
}