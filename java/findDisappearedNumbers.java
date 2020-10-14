class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Boolean> temp = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            temp.put(nums[i],true);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=1;i<=nums.length;i++) {
            if (!temp.containsKey(i))
                result.add(i);
        }
        return result;
    }
}