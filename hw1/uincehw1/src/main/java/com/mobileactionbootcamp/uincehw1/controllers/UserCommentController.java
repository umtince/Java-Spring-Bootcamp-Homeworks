package com.mobileactionbootcamp.uincehw1.controllers;

import com.mobileactionbootcamp.uincehw1.UserComment;
import com.mobileactionbootcamp.uincehw1.UserCommentDao;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class UserCommentController {

    private UserCommentDao userCommentDao;

    @PostMapping
    public ResponseEntity<UserComment> saveComment(@RequestBody UserComment userComment){
        userComment = userCommentDao.save(userComment);
        return new ResponseEntity<>(userComment, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<UserComment>> getAllComments(){
        List<UserComment> userComments = userCommentDao.findAll();

        return new ResponseEntity<>(userComments, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserComment> deleteComment(@RequestParam long id){

        UserComment userComment = userCommentDao.findById(id).orElseThrow();

        userCommentDao.delete(userComment);

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/update/{id}/{newComment}")
    public ResponseEntity<UserComment> updateComment(@RequestParam long id, String newComment){
        UserComment userComment =  userCommentDao.findById(id).orElseThrow();
        userComment.setComment(newComment);
        userCommentDao.save(userComment);

        return new ResponseEntity<>(userComment, HttpStatus.ACCEPTED);
    }
}
