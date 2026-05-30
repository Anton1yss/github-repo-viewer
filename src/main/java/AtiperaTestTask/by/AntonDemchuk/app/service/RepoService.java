package AtiperaTestTask.by.AntonDemchuk.app.service;

import AtiperaTestTask.by.AntonDemchuk.app.dto.RepoReadDto;
import AtiperaTestTask.by.AntonDemchuk.app.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepoService {

    private final RestTemplate restTemplate;
    private final BranchService branchService;

    public List<RepoReadDto> getAllReposFromUser(String username) {

        String url = "https://api.github.com/users/" + username + "/repos";

        try {
            RepoReadDto[] repos = restTemplate.getForObject(url, RepoReadDto[].class);

            return Arrays.stream(repos)
                    .filter(r -> !r.getFork())
                    .map(r -> RepoReadDto.builder()
                            .name(r.getName())
                            .branches(branchService.getBranches(username, r.getName()))
                            .fork(r.getFork())
                            .owner(r.getOwner())
                            .build())
                    .collect(Collectors.toList());

        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException(username);
        }
    }

}
