package com.ensf480.backend.models;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Role implements GrantedAuthority {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<Client> clients;

    public Set<Client> getUsers() {
        return clients;
    }

    public void setUsers(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
