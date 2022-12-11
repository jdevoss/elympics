package com.example.jpa.model;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;


@Entity // This tells Hibernate to make a table out of this class
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String a_name;

    @Column(name = "email")
    private String b_email;

    @Column(name = "player")
    private Boolean c_player;

    @Column(name = "viewer")
    private Boolean d_viewer;


    @Column(name = "gamertag")
    private String e_gamertag;


    @Column(name = "formulaOne")
    private Boolean f_formulaOne;

    @Column(name = "valorant")
    private Boolean g_valorant;

    @Column(name = "fifa")
    private Boolean h_fifa;

    @Column(name = "soloPlayer")
    private Boolean i_soloPlayer;

    @Column(name = "teamPlayer")
    private Boolean j_teamPlayer;

    private String playerTwo;

    private String playerThree;

    private String playerFour;

    private String playerFive;

    @Column(name = "teamName")
    private String k_teamName;

    public Visitor(String a_name, String b_email, Boolean c_player, Boolean d_viewer, String e_gamertag, Boolean xformulaOne, Boolean g_valorant,
                   Boolean h_fifa, Boolean i_soloPlayer, Boolean j_teamPlayer, String playerTwo, String playerThree,
                   String playerFour, String playerFive, String k_teamName) {
        this.a_name = a_name;
        this.b_email = b_email;
        this.c_player = c_player;
        this.d_viewer = d_viewer;
        this.e_gamertag = e_gamertag;
        this.f_formulaOne = xformulaOne;
        this.g_valorant = g_valorant;
        this.h_fifa = h_fifa;
        this.i_soloPlayer = i_soloPlayer;
        this.j_teamPlayer = j_teamPlayer;
        this.playerTwo = playerTwo;
        this.playerThree = playerThree;
        this.playerFour = playerFour;
        this.playerFive = playerFive;
        this.k_teamName = k_teamName;
    }

    public Visitor() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getB_email() {
        return b_email;
    }

    public void setB_email(String b_email) {
        this.b_email = b_email;
    }

    public Boolean getC_player() {
        return c_player;
    }

    public void setC_player(Boolean player) {
        this.c_player = player;
    }

    public Boolean getD_viewer() {
        return d_viewer;
    }

    public void setD_viewer(Boolean viewer) {
        this.d_viewer = viewer;
    }

    public Boolean getF_formulaOne() {
        return f_formulaOne;
    }

    public void setF_formulaOne(Boolean f_formulaOne) {
        this.f_formulaOne = f_formulaOne;
    }

    public Boolean getG_valorant() {
        return g_valorant;
    }

    public void setG_valorant(Boolean g_valorant) {
        this.g_valorant = g_valorant;
    }

    public Boolean getH_fifa() {
        return h_fifa;
    }

    public void setH_fifa(Boolean h_fifa) {
        this.h_fifa = h_fifa;
    }

    public Boolean getI_soloPlayer() {
        return i_soloPlayer;
    }

    public void setI_soloPlayer(Boolean c_soloPlayer) {
        this.i_soloPlayer = c_soloPlayer;
    }

    public Boolean getJ_teamPlayer() {
        return j_teamPlayer;
    }

    public void setJ_teamPlayer(Boolean d_teamPlayer) {
        this.j_teamPlayer = d_teamPlayer;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getPlayerThree() {
        return playerThree;
    }

    public void setPlayerThree(String playerThree) {
        this.playerThree = playerThree;
    }

    public String getPlayerFour() {
        return playerFour;
    }

    public void setPlayerFour(String playerFour) {
        this.playerFour = playerFour;
    }

    public String getPlayerFive() {
        return playerFive;
    }

    public void setPlayerFive(String playerFive) {
        this.playerFive = playerFive;
    }

    public String getK_teamName() {
        return k_teamName;
    }

    public void setK_teamName(String k_teamName) {
        this.k_teamName = k_teamName;
    }

    public String getE_gamertag() {
        return e_gamertag;
    }

    public void setE_gamertag(String b_gamertag) {
        this.e_gamertag = b_gamertag;
    }
}
