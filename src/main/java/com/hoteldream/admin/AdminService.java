package com.hoteldream.admin;

import com.hoteldream.domain.Admin;
import com.hoteldream.domain.Room;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {
    private final Admin admin;
    private final AdminForm adminForm;


    private final ModelMapper modelMapper;
    private final AdminRepository adminRepository;

    @PostConstruct
    public List<Admin> adminAccountReader() throws IOException {
        List<Admin> adminAccountList = null;

            Resource resource = new ClassPathResource("AdminAccount.csv");
             adminAccountList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8).stream()
                    .map(line -> {
                        String[] split = line.split("/");
                        return Admin.builder().adminID(split[0]).adminPW(split[1]).build();
                    }).collect(Collectors.toList());
            adminRepository.saveAll(adminAccountList);

        System.out.println("adminAccountList : " + adminAccountList);
        return adminAccountList;
    }


    public Admin createAdmin(AdminForm adminForm) {
        Admin admin = modelMapper.map(adminForm, Admin.class);
        Admin newAdmin = adminRepository.save(admin);

        return newAdmin;
    }


}


