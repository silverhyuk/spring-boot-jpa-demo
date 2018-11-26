package me.silverhyuk.springbootjpademo.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(PostRepositoryTestConfig.class)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void event() {
        Post post = new Post();
        post.setTitle("event");
        PostPublishedEvent event = new PostPublishedEvent(post);
        applicationContext.publishEvent(event);
    }


    @Test
    public void newEvent() {
        Post post = new Post();
        post.setTitle("hibernate");

        assertThat(postRepository.findByPost().size()).isEqualTo(0);

        postRepository.save(post.publish()); //JpaRepository
        postRepository.findByPost(); //PostCustomRepository
        postRepository.delete(post); //PostCustomRepository
        postRepository.flush(); // transaction 처리때문에 delete 쿼리가 rollback 되기 때문에 delete 가 실행되지 않음 > 강제로 처리
    }

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