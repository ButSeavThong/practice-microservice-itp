package com.thongfazon.account.data.init;

import com.thongfazon.account.data.entity.BranchEntity;
import com.thongfazon.account.data.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class BranchDataInitializer {

    private final BranchRepository branchRepository;

    @Bean
    CommandLineRunner initBranches() {
        return args -> {

            if (branchRepository.count() == 0) {

                BranchEntity branch1 = new BranchEntity();
                branch1.setBranchId(UUID.randomUUID());
                branch1.setName("Phnom Penh Main Branch");
                branch1.setOpening(true);

                BranchEntity branch2 = new BranchEntity();
                branch2.setBranchId(UUID.randomUUID());
                branch2.setName("Siem Reap Branch");
                branch2.setOpening(true);

                BranchEntity branch3 = new BranchEntity();
                branch3.setBranchId(UUID.randomUUID());
                branch3.setName("Battambang Branch");
                branch3.setOpening(false);

                branchRepository.saveAll(List.of(branch1, branch2, branch3));
            }
        };
    }
}