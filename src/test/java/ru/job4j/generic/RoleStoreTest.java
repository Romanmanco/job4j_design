package ru.job4j.generic;

import org.junit.Test;
import ru.job4j.generics.Role;
import ru.job4j.generics.RoleStore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

public class RoleStoreTest {

    @Test
    public void whenAddAndFind() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        Role result = roleStore.findById("1");
        assertThat(result.getRolename(), is("Driver"));
    }

    @Test
    public void whenAddAndFindIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        Role result = roleStore.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindIsDriver() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        roleStore.add(new Role("1", "Baker"));
        Role result = roleStore.findById("1");
        assertThat(result.getRolename(), is("Driver"));
    }

    @Test
    public void whenReplaceThenRolenameIsBaker() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        roleStore.replace("1", new Role("1", "Baker"));
        Role result = roleStore.findById("1");
        assertThat(result.getRolename(), is("Baker"));
    }

    @Test
    public void whenNoReplaceUserThenNoChangeRolename() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        roleStore.replace("10", new Role("10", "Baker"));
        Role result = roleStore.findById("1");
        assertThat(result.getRolename(), is("Driver"));
    }

    @Test
    public void whenDeleteUserThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        roleStore.delete("1");
        Role result = roleStore.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserThenRolenameIsDriver() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Driver"));
        roleStore.delete("10");
        Role result = roleStore.findById("1");
        assertThat(result.getRolename(), is("Driver"));
    }
}
