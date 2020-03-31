package guru.springframework.controllers;


import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.ui.Model;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;


/**
 * Created by jt on 6/17/17.
 */

@RunWith(SpringRunner.class)
@WebFluxTest
@Import(IndexController.class)
public class IndexControllerTest {

    WebTestClient webTestClient;


    @Autowired
    ApplicationContext applicationContext;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {

         webTestClient = WebTestClient.bindToController(controller).build();


    }

    @Test
    public void testMockMVC() throws Exception {
        //   MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(recipeService.getRecipes()).thenReturn(Flux.empty());


       /* mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));*/

        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody();


    }

    @Test
    public void getIndexPage() throws Exception {

      /*  //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId("1");

        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(Flux.fromIterable(recipes));

        ArgumentCaptor<Flux<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Flux.class);

        //when
        String viewName = controller.getIndexPage(model);


        //then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Flux<Recipe> fluxInController = argumentCaptor.getValue();
        List<Recipe> recipeList = fluxInController.collectList().block();
        assertEquals(2, recipeList.size());*/
    }

}