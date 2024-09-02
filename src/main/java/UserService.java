public class UserService {
    private final UserRepositary userRepositary;

    public UserService(UserRepositary userRepositary){
        this.userRepositary=userRepositary;
    }

    public String getUserName(int id){
        user user =userRepositary.findUserById(id);
        if (user != null){
            return user.getName();
        }
        else {
            return "unknown user";
        }
    }
}
