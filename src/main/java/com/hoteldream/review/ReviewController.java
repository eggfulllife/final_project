package com.hoteldream.review;
import com.hoteldream.domain.Review;
import com.hoteldream.domain.Room;
import com.hoteldream.room.RoomValidator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {
    private final  ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;
    private final Review review;
    private final ReviewForm reviewForm;


    @GetMapping("/review")
    public String reviewlist(Review review, Model model, Pageable pageable) {
        model.addAttribute("reviewlist", reviewService.getAllReview(pageable));

        return "/review";
    }
    @GetMapping("/new-review")
    public String newReview(Model model){
        model.addAttribute(new ReviewForm());

        return "/new-review";
    }

    @PostMapping("/new-review")
    public String newReviewSubmit(@Valid ReviewForm reviewForm, Model model){
        model.addAttribute(review);
        Review review = reviewService.createReview(reviewForm);

        return "redirect:/review";
    }
    //성구 시작

    // 성구
    @GetMapping("/reviewlist")
    public String getAllReviews(Model model) {
        List<ReviewForm> reviewDtos = reviewService.getAllReviews();
        model.addAttribute("reviews", reviewDtos);
        return "reviewlist";
    }

    @PostMapping("/deleteReview")
    public String deleteReview(@RequestParam Long id) {
        reviewService.deleteReview(id);
        return "redirect:/reviewcontrol";
    }
    @PostMapping("/reportReview") // 리포트버튼
    public String reportReview(@RequestParam Long id) {
        Review review = reviewRepository.getOne(id);
        review.setReport(1);
        reviewRepository.save(review);
        return "redirect:/reviewlist";
    }
    // 사업자 리플
    @GetMapping("/replyReview")
    public String showReplyForm(@RequestParam Long id, Model model) {
        Review review = reviewRepository.getOne(id);
        model.addAttribute("review", review);
        model.addAttribute("replyForm", new ReplyForm());
        return "replyForm";
    }


    @PostMapping("/saveReply")
    public String saveReply(@RequestParam Long id, @RequestParam String replyContent) {
        Review review = reviewRepository.getOne(id);
        review.setContent_reply(replyContent);
        reviewRepository.save(review);
        return "redirect:/reviewlist";
    }

    //악플관리
    @GetMapping("/reviewcontrol")
    public String reviewControl(Model model) {
        List<ReviewForm> reportedReviews = reviewService.getReportedReviews();
        model.addAttribute("reviews", reportedReviews);
        return "reviewcontrol";
    }



}
