package AtiperaTestTask.by.AntonDemchuk.app.controller;


import AtiperaTestTask.by.AntonDemchuk.app.dto.RepoReadDto;
import AtiperaTestTask.by.AntonDemchuk.app.service.RepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class RepoController {

    private final RepoService repoService;

    @GetMapping("/getAllUserRepos")
    public ResponseEntity<List<RepoReadDto>> getAllUserRepos(@RequestParam String username) {
        return ResponseEntity.ok(repoService.getAllReposFromUser(username));
    }

}
