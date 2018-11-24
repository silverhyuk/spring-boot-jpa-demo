package me.silverhyuk.springbootjpademo.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void crud() {
        Post post = new Post();
        post.setTitle("hibernate");
        post.setContent("hi, my name is choieunhyuk");
        postRepository.save(post); //JpaRepository
        postRepository.findByPost(); //PostCustomRepository
        postRepository.delete(post); //PostCustomRepository
        postRepository.flush(); // transaction 처리때문에 delete 쿼리가 rollback 되기 때문에 delete 가 실행되지 않음 > 강제로 처리
    }
}