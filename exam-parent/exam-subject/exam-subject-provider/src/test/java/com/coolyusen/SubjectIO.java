package com.coolyusen;

import com.coolyusen.exam.mapper.subject.SubjectMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴雨森
 * @data 2020/2/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectIO {

    @Autowired
    private SubjectMapper subjectMapper;

    

    @Test
    public void addSubjectByIO() throws IOException {

        ClassPathResource resource = new ClassPathResource("subject.txt");

        ImmutableList<String> subjects = Files.asCharSource(new File(resource.getURI().toString().substring(
                resource.getURL().toString().indexOf("/")
        )), Charsets.UTF_8).readLines();
        subjects.forEach(
                subject -> {
                    System.out.println(subject);
                }
        );

    }
}
