package com.codestates.sebmainproject009.user.controller;


import com.codestates.sebmainproject009.user.dto.UserPatchDto;
import com.codestates.sebmainproject009.user.dto.UserPostDto;
import com.codestates.sebmainproject009.user.entity.User;
import com.codestates.sebmainproject009.user.mapper.UserMapper;
import com.codestates.sebmainproject009.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @PostMapping("/signup")
    public ResponseEntity postUser(@RequestBody UserPostDto userPostDto){
        User user = userService.createUser(mapper.userPostDtoToUser(userPostDto));


        return new ResponseEntity<>(mapper.userToUserResponseDto(user), HttpStatus.CREATED);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity patchUser(@PathVariable long userId,
                                    @RequestBody UserPatchDto userPatchDto){
        userPatchDto.setUserId(userId);
        User user = userService.updateUser(mapper.userPatchDtoToUser(userPatchDto));

        return new ResponseEntity<>(mapper.userToUserResponseDto(user),HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable long userId){
        User user = userService.findUser(userId);

        return new ResponseEntity<>(mapper.userToUserResponseDto(user),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable long userId){
        userService.deleteUser(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
