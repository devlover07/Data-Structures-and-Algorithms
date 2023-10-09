function twoSum(nums: number[], target: number): number[] {
    const numIndexMap = new Map<number, number>();
    for (let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if (numIndexMap.has(complement)) {
            return [numIndexMap.get(complement)!, i];
        }
        numIndexMap.set(nums[i], i);
    }
    return [];
}
