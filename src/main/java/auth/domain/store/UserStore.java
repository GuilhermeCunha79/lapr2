package auth.domain.store;

import auth.domain.model.Email;
import auth.domain.model.Password;
import auth.domain.model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class UserStore {
    private Set<User> store = new HashSet<User>();


    public User create(String name, String email, String password) {
        return new User(new Email(email), new Password(password), name);
    }

    public boolean add(User user) {
        if (user != null) {
            if (!exists(user)) {
                this.store.add(user);
                serializeStore();
                return true;
            }
        }
        return false;
    }

    public boolean remove(User user) {
        if (user != null)
            return this.store.remove(user);
        return false;
    }

    public Optional<User> getById(String email) {
        return this.getById(new Email(email));
    }

    public Optional<User> getById(Email email) {
        for (User user : this.store) {
            if (user.hasId(email))
                return Optional.of(user);
        }
        return Optional.empty();
    }

    public boolean exists(String email) {
        Optional<User> result = getById(email);
        return result.isPresent();
    }

    public boolean exists(Email email) {
        Optional<User> result = getById(email);
        return result.isPresent();
    }

    public boolean exists(User user) {
        return this.store.contains(user);
    }

    public void setStore(Set<User> uList){
        Set<User> users= new HashSet<>(uList);
        this.store = users;
    }


    private void serializeStore() {
        try {
            FileOutputStream out = new FileOutputStream("data\\user.dat");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(this.store);
            outputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
