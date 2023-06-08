package nguyenquangkhai.Lab3.Validator;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidator;
import nguyenquangkhai.Lab3.Validator.annotation.ValidUsername;
import nguyenquangkhai.Lab3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}
