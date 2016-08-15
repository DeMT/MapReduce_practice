III練習用mapreduce ，資料流向 Map->partition->grouping comparator ->reducer

沒有用到combiner(map端的reducer)
MySortingComparator沒有在APP.java裡面指定也沒用到... 不過group的時候其實已經排好了

HDFS裡面裝的是模擬資料，模擬兩個人進便利商店、結帳、出來的log
這隻程式沒有實際在cluster上跑過

2016/08/15上傳
