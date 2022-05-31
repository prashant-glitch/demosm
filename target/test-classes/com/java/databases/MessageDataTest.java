package databases;

import org.springframework.context.ApplicationContextAware;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MessageDataTest implements ApplicationContextAware{
    @Autowired
    MessageDAO messageDAO;
    ApplicationContext context;
    @Test
    public void testUpdate() {
        // context.getBean(MessageDAO.class);
        context.getAutowireCapableBeanFactory().autowireBean(messageDAO);
        Message message = messageDAO.retriveMessageById(1);
        message.setStatus(7);
        assertEquals(1, messageDAO.update(message));
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        this.context = applicationContext;
    }
    
}
