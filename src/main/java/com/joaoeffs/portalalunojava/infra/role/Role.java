package com.joaoeffs.portalalunojava.infra.role;

public enum Role {

    ADMIN("admin"),
    PROFESSOR("professor"),
    ALUNO("aluno");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
