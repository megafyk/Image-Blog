package com.megafyk.controller;

import com.megafyk.model.FileBucket;
import com.megafyk.model.Post;
import com.megafyk.model.User;
import com.megafyk.service.PostService;
import com.megafyk.service.UserService;
import com.megafyk.util.FileValidator;
import com.megafyk.util.MultiFileValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Handle file upload and create post from file upload
 */
@Controller
@RequestMapping(value = "/create")
public class FileUploadController {

    private final static String UPLOAD_LOCATION = "C:/Users/megafyk/Desktop/images/fulls/";
    private final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    FileValidator fileValidator;

    @Autowired
    MultiFileValidator multiFileValidator;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @InitBinder("fileBucket")
    protected void initBinderFileBucket(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }

    @InitBinder("multiFileBucket")
    protected void initBinderMultiFileBucket(WebDataBinder binder) {
        binder.setValidator(multiFileValidator);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getSingleUploadPage(ModelMap model) {
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        return "createPost";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String singleFileUpload(@Valid FileBucket fileBucket, BindingResult result, ModelMap model) throws IOException {

        if (result.hasErrors()) {
            System.out.println("validation errors");
            return "createPost";
        } else {
            System.out.println("Fetching file");
            MultipartFile multipartFile = fileBucket.getFile();

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findBySSO(authentication.getName());
            String file_uploaded = generate_name(timestamp.getTime(), user.getId());

            //Do something with file...
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + file_uploaded));

            //Create new post...
            Post post = new Post();
            post.setTitle(file_uploaded);
            post.setTitle_clean(file_uploaded);
            post.setArticle("This is post number: " + timestamp.getTime());
            post.setAuthor_id(user.getId());
            post.setStatus(true);
            post.setComments_enabled(true);
            post.setViews(0);
            post.setLikes(0);
            post.setImage_uri(file_uploaded);
            post.setDate_published(timestamp);
            postService.savePost(post);

            String fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName);
            return "success";
        }
    }

    private String generate_name(Long time, int userId){
        return time + "_" + userId + "_o.png";
    }
}
