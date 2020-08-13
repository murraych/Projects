/* eslint-disable no-unused-vars, no-console */
import { shallowMount, Wrapper } from "@vue/test-utils";
import UserList from "@/components/UserList.vue";

import chai from "chai";
chai.should();

describe("UserList.vue", () => {
  /** @type Wrapper */
  let wrapper;

  // test user data
  const users = [
    {
      firstName: "John",
      lastName: "Smith",
      username: "jsmith",
      emailAddress: "jsmith@gmail.com",
      status: "Active"
    },
    {
      firstName: "Anna",
      lastName: "Bell",
      username: "abell",
      emailAddress: "abell@yahoo.com",
      status: "Active"
    },
    {
      firstName: "George",
      lastName: "Best",
      username: "gbest",
      emailAddress: "gbest@gmail.com",
      status: "Disabled"
    },
    {
      firstName: "Ben",
      lastName: "Carter",
      username: "bcarter",
      emailAddress: "bcarter@gmail.com",
      status: "Active"
    },
    {
      firstName: "Katie",
      lastName: "Jackson",
      username: "kjackson",
      emailAddress: "kjackson@yahoo.com",
      status: "Active"
    },
    {
      firstName: "Mark",
      lastName: "Smith",
      username: "msmith",
      emailAddress: "msmith@foo.com",
      status: "Disabled"
    }
  ];

  const filter = {
    firstName: "",
    lastName: "",
    username: "",
    emailAddress: "",
    status: ""
  };

  beforeEach(() => {
    wrapper = shallowMount(UserList);
    wrapper.setData({
      users: users,
      filter: filter
    });
  });

  describe("Part one tests", () => {
    it("should display a list of users with correct data", () => {
      const rows = wrapper.findAll("#tblUsers tbody tr");
      rows.length.should.equal(7);
      let columns = rows.at(1).findAll("td");
      columns.at(0).text().should.equal(users[0].firstName);
      columns.at(1).text().should.equal(users[0].lastName);
      columns.at(2).text().should.equal(users[0].username);
      columns.at(3).text().should.equal(users[0].emailAddress);
      columns.at(4).text().should.equal(users[0].status);
    });
  });

  describe("Part two tests: Column Filters", () => {
    it("should set the filter firstName property when the filter changes", () => {
      const filter = wrapper.find("#firstNameFilter");
      filter.setValue("anna");
      wrapper.vm.filter.firstName.should.equal("anna");
    });

    it("should set the filter lastName property when the filter changes", () => {
      const filter = wrapper.find("#lastNameFilter");
      filter.setValue("jackson");
      wrapper.vm.filter.lastName.should.equal("jackson");
    });

    it("should set the filter username property when the filter changes", () => {
      const filter = wrapper.find("#usernameFilter");
      filter.setValue("msmith");
      wrapper.vm.filter.username.should.equal("msmith");
    });

    it("should set the filter emailAddress property when the filter changes", () => {
      const filter = wrapper.find("#emailFilter");
      filter.setValue("bcarter@gmail.com");
      wrapper.vm.filter.emailAddress.should.equal("bcarter@gmail.com");
    });

    it("should set the filter status property when the filter changes", () => {
      const filter = wrapper.find("#statusFilter");
      filter.setValue("Disabled");
      wrapper.vm.filter.status.should.equal("Disabled");
    });
  });

  describe("Part three tests: Computed Properties", () => {

    it("should perform a case insensitive filter of users by first name", async () => {
      const filter = wrapper.find("#firstNameFilter");
      filter.setValue("anna");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(1);
    });

    it("should perform a case insensitive filter of users by last name", async () => {
      const filter = wrapper.find("#lastNameFilter");
      filter.setValue("jackson");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(1);
    });

    it("should perform a case insensitive filter of users by username", () => {
      const filter = wrapper.find("#usernameFilter");
      filter.setValue("msmith");
      wrapper.vm.filteredList.length.should.equal(1);
    });

    it("should perform a case insensitive filter of users by email address", async () => {
      const filter = wrapper.find("#emailFilter");
      filter.setValue("bcarter@gmail.com");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(1);
    });

    it("should filter users by diabled status", async () => {
      const filter = wrapper.find("#statusFilter");
      filter.setValue("Disabled");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(2);
    });

    it("should filter users by active status", async () => {
      const filter = wrapper.find("#statusFilter");
      filter.setValue("Active");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(4);
    });

    it("should show all users when status filter is blank", async () => {
      const filter = wrapper.find("#statusFilter");
      filter.setValue("");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(6);
    });

    it("should be able to use multiple filters", async () => {
      const firstNameFilter = wrapper.find("#firstNameFilter");
      const lastNameFilter = wrapper.find("#lastNameFilter");
      firstNameFilter.setValue("n");
      lastNameFilter.setValue("e");
      await wrapper.vm.$nextTick();
      wrapper.vm.filteredList.length.should.equal(2);
    });
  });

  describe("Part four tests", () => {
    it("renders a row with the class of disabled if the user status equals Disabled", () => {
      wrapper.findAll(".disabled").length.should.equal(2);
    });
  });
});
