package SHI.Server.Test.edu.hello;

import lombok.Getter;

@Getter
public class Hello {

    private final long id;
    private final String content;
    
    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
