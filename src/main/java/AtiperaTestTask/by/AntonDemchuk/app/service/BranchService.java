package AtiperaTestTask.by.AntonDemchuk.app.service;

import AtiperaTestTask.by.AntonDemchuk.app.dto.BranchReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final RestTemplate restTemplate;

    public List<BranchReadDto> getBranches(String username, String repoName) {
        String url = "https://api.github.com/repos/" + username + "/" + repoName + "/branches";

        BranchReadDto[] branches = restTemplate.getForObject(url, BranchReadDto[].class);

        if (branches == null) return List.of();

        return Arrays.stream(branches)
                .map(b -> BranchReadDto.builder()
                        .name(b.getName())
                        .commit(b.getCommit())
                        .build())
                .collect(Collectors.toList());
    }
}
