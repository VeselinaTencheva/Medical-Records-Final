package com.example.Medical.Records.v10.service.user;


import com.example.Medical.Records.v10.data.entity.User;
import com.example.Medical.Records.v10.data.repository.UserRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

//    private RoleRepository roleRepo;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepo.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return user;
////        return this.userRepo.findByEmail(email)
////                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
////
////        User user = userRepo.findByUsername(username);
////        if (user == null) {
////            return new org.springframework.security.core.userdetails.User(
////                    " ", " ", true, true, true, true,
////                    getAuthorities(Arrays.asList(
////                            roleRepo.findByAuthority("ROLE_USER"))));
////        }
////
////        return new org.springframework.security.core.userdetails.User(
////                user.getEmail(), user.getPassword(), user.isEnabled(), true, true,
////                true, getAuthorities(user.getAuthorities()));
//    }

//    private Collection<? extends GrantedAuthority> getAuthorities(
//            Collection<Role> roles) {
//
//        return getGrantedAuthorities(getPrivileges(roles));
//    }

//    private List<String> getPrivileges(Collection<Role> roles) {
//
//        List<String> privileges = new ArrayList<>();
//        List<Privilege> collection = new ArrayList<>();
//        for (Role role : roles) {
//            privileges.add(role.getAuthority());
//            collection.addAll(role.getPrivileges());
//        }
//        for (Privilege item : collection) {
//            privileges.add(item.getName());
//        }
//        return privileges;
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }

//    @Override
//    public User findUserByUserName(String username) {
//        return this.userRepo.findByUsername(username);
//    }
//
//    @Override
//    public User findUserByEmail(String email) {
//        return this.userRepo.findByEmail(email);
//    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return this.userRepo.findById(id)
                .orElseThrow(() ->  new IllegalArgumentException("Invalid User ID: " + id));
//        TODO change immediately after adding security
//                        new UsernameNotFoundException("ID not found"));
    }

    @Override
    public void deleteUser(User user) {
        this.userRepo.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
