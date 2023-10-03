package org.operationsix.ClientService.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    private String userName;
    private String email;
    private boolean isActive;
    private boolean isAdmin;
}
