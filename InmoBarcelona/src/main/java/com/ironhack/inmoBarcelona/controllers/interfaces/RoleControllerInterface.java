package com.ironhack.inmoBarcelona.controllers.interfaces;

import com.ironhack.inmoBarcelona.dtos.RoleToUserDTO;
import com.ironhack.inmoBarcelona.models.Role;

public interface RoleControllerInterface {
    /**
     * Save a new role
     *
     * @param role the role to be saved
     */
    void saveRole(Role role);

    /**
     * Add a role to a user
     *
     * @param roleToUserDTO object containing the username and role name to be added to the user
     */
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
