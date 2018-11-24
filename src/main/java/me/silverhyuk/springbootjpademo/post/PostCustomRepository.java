package me.silverhyuk.springbootjpademo.post;

import java.util.List;

public interface PostCustomRepository {

    List<Post> findByPost();

}
