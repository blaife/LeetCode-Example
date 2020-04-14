package leetcode.t355designtwitter;

import java.util.*;

/**
 * @author Blaife
 * @description 哈希表 + 链表 + 优先队列（经典多路归并问题）
 * @data 2020/4/13 22:26
 */
public class TwitterMultichannel {
    /**
     * 用户 id 和推文（单链表）的对应关系
     */
    private Map<Integer, Tweet> twitter;

    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;

    /**
     * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
     * PriorityQueue 一个基于优先级的无界优先级队列。
     */
    private static PriorityQueue<Tweet> maxHeap;

    /**
     * 推特数量
     */
    private static final int TWEET_SIZE = 10;

    /**
     * 初始化方法
     */
    public TwitterMultichannel() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        // 这是相当于直接对maxHeap中的内容进行了排序（根据timestamp）
        maxHeap = new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
    }

    /**
     * 发布一个tweet
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)) {
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            // 新的推特在头部，旧的推特在尾部
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     * 获取用户及关注用户的前十条推特
     */
    public List<Integer> getNewsFeed(int userId) {
        // 由于是全局使用的，使用之前需要清空
        maxHeap.clear();
        // 如果自己发了推文也要算上
        if (twitter.containsKey(userId)) {
            maxHeap.offer(twitter.get(userId));
        }
        // 获取关注列表
        Set<Integer> followingList = followings.get(userId);
        // 将关注列表发布过推特的用户添加到maxHeap
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }
        // 需要返回的tweet数据
        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() <= TWEET_SIZE) {
            Tweet head = maxHeap.poll();
            res.add(head.id);

            // 执行完毕之后如果当前twitter组中存在下一条则添加进去
            if (head.next != null) {
                maxHeap.offer(head.next);
            }
        }
        return res;
    }


    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId 发起关注者 id
     * @param followeeId 被关注者 id
     */
    public void follow(int followerId, int followeeId) {
        // 被关注人不能是自己
        if (followeeId == followerId) {
            return;
        }

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }


    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     *
     * @param followerId 发起取消关注的人的 id
     * @param followeeId 被取消关注的人的 id
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);

        if (followingList == null) {
            return;
        }
        // 这里删除之前无需做判断，因为查找是否存在以后，就可以删除，反正删除之前都要查找
        followingList.remove(followeeId);
    }

    /**
     * 推文类，是一个单链表（结点视角）
     */
    private class Tweet {
        /**
         * 推文 id
         */
        private int id;

        /**
         * 发推文的时间戳
         */
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    public static void main(String[] args) {

        TwitterMultichannel twitter = new TwitterMultichannel();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.postTweet(2, 2);
        twitter.postTweet(1, 3);
        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }
}
