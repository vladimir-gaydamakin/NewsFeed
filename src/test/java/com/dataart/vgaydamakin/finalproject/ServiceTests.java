package com.dataart.vgaydamakin.finalproject;

import com.dataart.vgaydamakin.finalproject.repository.MainRepository;
import com.dataart.vgaydamakin.finalproject.utility.ZipFileHandler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {
    @Mock
    private ZipFileHandler zipFileHandler;
    @Mock
    private MainRepository mainRepository;

}
